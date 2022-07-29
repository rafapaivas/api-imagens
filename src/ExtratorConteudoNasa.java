import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa implements ExtratorConteudo{
    public List<Conteudo> extraiConteudos(String json) {

        // extrair os dados para usar na aplicação (título, poster e classificação
        var parser =  new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        
        List<Conteudo> conteudos = new ArrayList<>();
        
        //popular a lista de conteúdos
        for (Map<String, String> atributos: listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }
        return conteudos;
    }
}
