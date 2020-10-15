package fr.usmb.m2isc.chronopost.ejb;

import fr.usmb.m2isc.chronopost.jpa.Coordinate;
import fr.usmb.m2isc.chronopost.jpa.Package;
import fr.usmb.m2isc.chronopost.jpa.PackageStatus;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Package's EJB that will serve as an interface between the JPA objects and the Database objects
 * The EJB will be used by the Servlets and provide the requested records from the DB
 * This EJB is Stateless since we don't need instances variables so it will be less costly for the server
 *
 * Also the EJB is local since we use it on only one server
 */
@Stateless
@LocalBean
public class PackageEJB {

    // Interface used for the JPA/Database mapping
    @PersistenceContext
    private EntityManager em;

    /**
     * Mandatory constructor without parameters
     */
    public PackageEJB() { }

    /**
     * Add a new package, instantiating a package will also instantiate a first package status step
     *
     * @param weight package's weight
     * @param value package's value
     * @param origin package's origin
     * @param destination package's destination
     * @param latitude package's latitude
     * @param longitude package's longitude
     * @return Added package
     */
    public Package addPackage(float weight, float value, String origin, String latitude, String longitude, String destination) {
        Package p = new Package(weight, value, origin, destination);
        Coordinate coordinate = new Coordinate(latitude, longitude);
        em.persist(coordinate);
        PackageStatus ps = new PackageStatus(coordinate, origin, PackageStatus.State.REGISTRATION);
        em.persist(ps);
        List<PackageStatus> packageStatusList = new ArrayList<>();
        packageStatusList.add(ps);
        p.setPackageStatusList(packageStatusList);
        em.persist(p);
        return p;
    }

    /**
     * Find a package according to its Id
     * @param id id of the package we are looking for
     * @return Package
     */
    public Package findById(long id) {
        return em.find(Package.class, id);
    }

    /**
     * List all the available Package's ids, used to fill in the combobox when selecting a Package to monitor
     * @return long[]
     */
    public List<Long> listPackageIds() {
        TypedQuery<Long> tq = em.createQuery("SELECT p.id FROM Package p ORDER BY p.id ASC", Long.class);
        return tq.getResultList();
    }

    /**
     * Add a new package status at the end of the package status list
     * @param id package's identifier
     * @param packageStatus the package status to be added
     * @return Package
     */
    public Package addPackageStatus(long id, PackageStatus packageStatus) {
        Package p = this.findById(id);
        p.addPackageStatus(packageStatus);
        return p;
    }

    /**
     * Update a package status of a package
     * @param id package's identifier
     * @param packageStatusId package status id of the edited status
     * @param location possibly edited location
     * @param latitude possibly edited latitude
     * @param longitude possibly edited longitude
     * @param state possibly edited state
     * @return Package
     */
    public Package editPackageStatus(long id, long packageStatusId, String location, String latitude, String longitude, String state) {
        Package p = this.findById(id);
        p.editPackageStatus(packageStatusId, location, latitude, longitude, state);
        return p;
    }

    /**
     * Find a package status according to its Id
     * @param packageStatusId the package status identifier
     * @return PackageStatus
     */
    public PackageStatus findPackageStatus(long packageStatusId) {
        return em.find(PackageStatus.class, packageStatusId);
    }
}
