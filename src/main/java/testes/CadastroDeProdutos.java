package testes;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import modelo.Categoria;
import modelo.Produto;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;


public class CadastroDeProdutos {

    public static void main(String[] args) {
        //cadastrarProduto();
        Long id = 1l;
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDao = new ProdutoDAO(em);

       // Produto p = produtoDao.buscarPorId(id);
       // System.out.println(p.getPreco());

       // List<Produto> todos = produtoDao.buscarTodos();
       // List<Produto> todos = produtoDao.buscarPorNome("Iphone");
        //List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("CELULARES");
        //todos.forEach(p2 -> System.out.println(p2.getCategoria().getNome()));

        BigDecimal procoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Iphone");
        System.out.println(procoDoProduto);

    }

        public static void cadastrarProduto(){
            Categoria celulares = new Categoria("CELULARES");
            Produto celular = new Produto("Xiaomi redmi","Muito Legal",new BigDecimal("800"), celulares);

            EntityManager em = JPAUtil.getEntityManager();
            ProdutoDAO produtoDao = new ProdutoDAO(em);
            CategoriaDAO categoriaDAO = new CategoriaDAO(em);
            em.getTransaction().begin();

            categoriaDAO.cadastrar(celulares);
            produtoDao.cadastrar(celular);

            em.getTransaction().commit();
            em.close();
        }

}
