package bibliotecaServidor;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Biblioteca {
    @JsonProperty("livros")
    private List<Livro> livros;

    public Biblioteca() {
    }

    public Biblioteca(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
