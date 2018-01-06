/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Entities.Semester;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author MartinLodahl
 */
public class Control {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //1
        em.createNamedQuery("Student.findAll").getResultList();
//        //2
        em.createNamedQuery("Student.findByFirstname").setParameter("firstname", "Anders").getResultList();
        //3 &  4
        Query query = em.createNativeQuery("INSERT INTO STUDENT (FIRSTNAME, LASTNAME, CURRENTSEMESTER_ID) "
                + " VALUES(,?,?,?)");
        query.setParameter(1, "Jeppe");
        query.setParameter(2, "Jensen");
        query.setParameter(3, "2");
        query.executeUpdate();

        //5
        em.createNamedQuery("Student.findByLastname").setParameter("lastname", "And").getResultList();
        //6
        Semester sem = new Semester(); sem.setId(3l);
        em.createNamedQuery("Student.findSumBySemester").setParameter("currentSemesterID", sem).getResultList();
        //7
        em.createNamedQuery("Student.findSum").getResultList();
        //8
        query = em.createNativeQuery("SELECT teachers_ID FROM exampreparationjpql.teacher_semester GROUP BY teachers_ID order by COUNT(teaching_ID) DESC;");
        query.getResultList().get(0).toString();
        
        em.getTransaction().commit();
        em.close();
    }

}
