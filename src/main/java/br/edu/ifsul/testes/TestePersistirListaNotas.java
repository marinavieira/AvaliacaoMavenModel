/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Nota;
import br.edu.ifsul.modelo.Prova;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author marina.ferreira
 */
public class TestePersistirListaNotas {
        public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AvaliacaoMavenModelPU");
        EntityManager em = emf.createEntityManager();
        Nota n = em.find(Nota.class, 17);
        Prova p = em.find(Prova.class, 6);
        p.adicionarNota(n);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
