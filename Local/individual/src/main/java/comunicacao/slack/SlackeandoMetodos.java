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
public class SlackeandoMetodos {

    private UsuarioDAO token;
    private String slackToken;
    private Slack slack;
    private ChatPostMessageRequest message;
    private ChatPostMessageResponse response;

    public void notificar(Double porcentagem) throws SlackApiException, IOException {
        token = new UsuarioDAO();
        slackToken = token.coletarCodigoSlack();
        slack = Slack.getInstance();

        message = ChatPostMessageRequest.builder()
                .token(slackToken)
                .channel("#canal-de-alerta")
                .text("Atenção a execução de todas as etapas antes do loop ocorreu com sucesso!")
                .build();
        response = slack.methods().chatPostMessage(message);
        System.out.println("Mensagem enviada com sucesso! ID da mensagem: " + response.getTs());
    

    }

    public void notificarErroHd(Double porcentagem) throws SlackApiException, IOException {
        token = new UsuarioDAO();
        slackToken = token.coletarCodigoSlack();
        slack = Slack.getInstance();

        message = ChatPostMessageRequest.builder()
                .token(slackToken)
                .channel("#canal-de-alerta")
                .text(String.format("Atenção O seu Hd alcançou o límite máximo configurado para alerta, a porcentagem de uso alcançou %.2f, favor verificar o motivo do erro!",porcentagem))
                .build();
        response = slack.methods().chatPostMessage(message);
        System.out.println("Mensagem enviada com sucesso! ID da mensagem: " + response.getTs());
    }
    public void notificarErroMem(Double porcentagem) throws SlackApiException, IOException {
        token = new UsuarioDAO();
        slackToken = token.coletarCodigoSlack();
        slack = Slack.getInstance();

        message = ChatPostMessageRequest.builder()
                .token(slackToken)
                .channel("#canal-de-alerta")
                .text(String.format("Atenção a memória alcançou o límite máximo configurado para alerta, a porcentagem de uso alcançou %.2f, favor aumentar a quantidade de memória ou reduzir o número de processos inicializados no sistema!",porcentagem))
                .build();
        response = slack.methods().chatPostMessage(message);
        System.out.println("Mensagem enviada com sucesso! ID da mensagem: " + response.getTs());
    }
    
    public void notificarErroProcessador(Double porcentagem) throws SlackApiException, IOException {
        token = new UsuarioDAO();
        slackToken = token.coletarCodigoSlack();
        slack = Slack.getInstance();

        message = ChatPostMessageRequest.builder()
                .token(slackToken)
                .channel("#canal-de-alerta")
                .text(String.format("Atenção o processador alcançou o límite máximo configurado para alerta, a porcentagem de uso alcançou %.2f, favor reduzir o número de processos!",porcentagem))
                .build();
        response = slack.methods().chatPostMessage(message);
        System.out.println("Mensagem enviada com sucesso! ID da mensagem: " + response.getTs());
    }
}
