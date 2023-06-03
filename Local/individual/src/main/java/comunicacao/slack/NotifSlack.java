/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacao.slack;
import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import java.io.IOException;
import login.UsuarioDAO;
/**
 *
 * @author rafae
 */
public class NotifSlack {
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public static void main(String[] args) throws SlackApiException, IOException {
        // Define o token de acesso do bot
        UsuarioDAO token = new UsuarioDAO();
        String slackToken = token.coletarCodigoSlack();
        // Cria uma instância do cliente da Slack API
        Slack slack = Slack.getInstance();

        // Cria uma mensagem com um bloco de texto simples
        ChatPostMessageRequest message = ChatPostMessageRequest.builder()
                .token(slackToken)
                .channel("#canal-de-alerta")
                .text("Atenção! Houve uma falha no sistema.")
                .build();

        // Envia a mensagem
        ChatPostMessageResponse response = slack.methods().chatPostMessage(message);

        // Imprime o resultado da operação
        System.out.println("Mensagem enviada com sucesso! ID da mensagem: " + response.getTs());
    }

    @Override
    public String toString() {
        return "notifSlack{" + "codigo=" + codigo + '}';
    }
}
