/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Nota;
import br.edu.ifsul.modelo.Prova;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author marina.ferreira
 */
public class TestePersistirNota {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AvaliacaoMavenModelPU");
        EntityManager em = emf.createEntityManager();
        Nota n = new Nota();
        n.setAluno("Marina");
        n.setNota(10.00);
        n.setProva(em.find(Prova.class, 6));
        em.getTransaction().begin();
        em.persist(n);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
