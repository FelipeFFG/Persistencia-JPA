package dao;



import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDAO {

    private EntityManager em;

    public ProdutoDAO(EntityManager em){
        this.em=em;
    }


    public void cadastrar(Produto produto){
        this.em.persist(produto);
    }




    public Produto buscarPorId(Long id){
        return em.find(Produto.class,id);
    }

    public List<Produto> buscarTodos(){
        TypedQuery<Produto> query = em.createQuery("SELECT c FROM Produto c", Produto.class);
        List<Produto> results = query.getResultList();
        return results;
    }

    public List<Produto> buscarPorNome(String nome){
        TypedQuery<Produto> query = em.createQuery("SELECT c FROM Produto c where  c.nome = :nome", Produto.class);
        List<Produto> results = query.setParameter("nome",nome).getResultList();
        return results;
    }

    public List<Produto> buscarPorNomeDaCategoria(String nome){
        TypedQuery<Produto> query = em.createQuery("SELECT c FROM Produto c where  c.categoria.nome = :nome", Produto.class);
        List<Produto> results = query.setParameter("nome",nome).getResultList();
        return results;
    }


    public BigDecimal buscarPrecoDoProdutoComNome(String nome){
        String jpql = "SELECT c.preco FROM Produto c where  c.nome = :nome";
        return em.createQuery(jpql, BigDecimal.class).setParameter("nome",nome).getSingleResult();
    }
}
