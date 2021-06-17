package modelo;


import javax.persistence.*;

@Entity  //existe uma tabela no banco de dados que esta mapeando
@Table(name= "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;


    public Categoria(String nome) {
        this.nome = nome;
    }

 


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
