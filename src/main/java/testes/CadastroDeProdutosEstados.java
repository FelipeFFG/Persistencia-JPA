package testes;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import modelo.Categoria;
import modelo.Produto;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;


public class CadastroDeProdutosEstados {

    public static void main(String[] args) {


        Categoria celulares = new Categoria("CELULARES");


        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        em.persist(celulares);
        celulares.setNome("XPTO");

        em.flush();
        em.clear();


        celulares = em.merge(celulares);
        celulares.setNome("1234");
        em.flush();

        Categoria cel = em.find(Categoria.class,8);
        em.remove(cel);
        em.close();
    }
}
