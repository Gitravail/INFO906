package fr.usmb.m2isc.chronopost.ejb;

import fr.usmb.m2isc.chronopost.jpa.Coordinate;
import fr.usmb.m2isc.chronopost.jpa.Package;
import fr.usmb.m2isc.chronopost.jpa.PackageStatus;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
public class PackageEJB {
    @PersistenceContext
    private EntityManager em;

    /**
     * Mandatory constructor without parameters
     */
    public PackageEJB() {
    }

    /**
     * Add a new package
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

    public Package findById(long id) {
        Package p = em.find(Package.class, id);
        return p;
    }

    public List<Long> listPackageIds() {
        TypedQuery<Long> tq = em.createQuery("SELECT p.id FROM Package p ORDER BY p.id ASC", Long.class);
        return tq.getResultList();
    }

    public Package addStep(long id, PackageStatus packageStatus) {
        Package p = this.findById(id);
        p.addStatus(packageStatus);
        return p;
    }

    public PackageStatus findPackageStatus(long packageStatusId) {
        return em.find(PackageStatus.class, packageStatusId);
    }
}
