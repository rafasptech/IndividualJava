/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import com.mysql.cj.protocol.Resultset;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitor
 */
public class LogTeste {

    public void login(ResultSet usuario,Boolean rdusuario) {

        File login = new File("log.txt");

        //throws IOException e try e catch
        if (!login.exists()) {
            try {
                login.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(LoginJframe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String frase = "O Usuário fez login!";

        if (!rdusuario) {
            frase = "Autenticação Inválida!";
        }

        ZonedDateTime horarioDeBrasilia = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        LocalDateTime dateTimeMetrica = horarioDeBrasilia.toLocalDateTime();

        //Criar uma arraylist que vai armazenar o registro em si dos logins
        List<String> lista = new ArrayList<>();
        lista.add(
                dateTimeMetrica.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss ")) + frase);

        //A classe Formatter permite que a saída de dados formatados seja
        //enviada para qualquer fluxo baseado em texto de uma maneira semelhante ao método System.out.printf.
        //Classe files é adicionada para manipulação de arquivos e diretórios
        //StandardOpenOption especifica como o arquivo deve ser aberto,
        //no caso do APPEND Os dados são gravados no final do arquivo.      
        try {
            Files.write(Paths.get(login.getPath()), lista, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(LoginJframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
