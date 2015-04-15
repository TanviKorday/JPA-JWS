package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import model.Site;

@Path("/site")
public class SiteDao {

	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("Asg5");
	EntityManager em = factory.createEntityManager();

	/**
	 * createSite
	 * 
	 * @param site
	 * @return List<Site>
	 */
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> createSite(Site site) {
		em.getTransaction().begin();
		em.persist(site);
		em.getTransaction().commit();
		Query query = em.createQuery("select site from Site site");
		return (List<Site>) query.getResultList();
	}

	/**
	 * findSite
	 * 
	 * @param siteID
	 * @return Site
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Site findSite(@PathParam("id") int siteID) {
		Site site = null;
		site = em.find(Site.class, siteID);
		return site;
	}

	/**
	 * findAllSites
	 * 
	 * @return List<Site>
	 */
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> findAllSites() {
		List<Site> sites=new ArrayList<Site>();
		em = factory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select site from Site site");
		sites= query.getResultList();
		em.getTransaction().commit();
		em.close();
		return sites;
	}

	/**
	 * removeSite
	 * 
	 * @param siteId
	 * @return List<Site>
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> removeSite(@PathParam("id") int siteId) {
		List<Site> sites = new ArrayList<Site>();

		Site site = null;

		em = factory.createEntityManager();
		em.getTransaction().begin();

		site = em.find(Site.class, siteId);
		em.remove(site);

		Query query = em.createQuery("select site from Site site");
		sites = query.getResultList();

		em.getTransaction().commit();
		em.close();

		return sites;
	}

	
	/**
	 * updateSite
	 * 
	 * @param siteId
	 * @param newSite
	 * @return List<Site>
	 */
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> updateSite(@PathParam("id") int siteId, Site newSite) {
		List<Site> sites = new ArrayList<Site>();
		em.getTransaction().begin();

		newSite.setId(siteId);
		em.merge(newSite);

		Query query = em.createQuery("select site from Site site");
		sites = query.getResultList();

		em.getTransaction().commit();
		em.close();
		return sites;
	}

	
	
	public static void main(String[] args) {
		SiteDao dao = new SiteDao();

		// TEST CODE COMMENTED ON PURPOSE AS THE TESTS WERE PERFORMED ONE AT
		// TIME

		// Create Site
		 Site site =new Site(0,34.34,32.67,"Site 3");
		 List<Site>sites=dao.createSite(site);
		 for (Site s:sites)
		 {
		 System.out.println(s.getName());
		 }
	}

	

}
