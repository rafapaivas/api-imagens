import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;


public class GeradoraDeFigurinhas {

    public void cria( InputStream inputStream, String nomeArquivo) throws Exception {
        // leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        BufferedImage original = ImageIO.read(inputStream);

        //criar nova imagem em memória com transparência
        int largura = original.getWidth();
        int altura = original.getHeight();
        int novaAltura = altura + 150;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // escrever na imagem
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(original, 0, 0, null);

        // configuar fonte
        var fonte = new Font(Font.MONOSPACED, Font.TRUETYPE_FONT,120);
        graphics.setColor(Color.green);
        graphics.setFont(fonte);

        // escrever na nova imagem
        graphics.drawString("CODANDO", 150, novaAltura -60);

        // colocar a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }


}
