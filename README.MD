# Icaro

> O objetivo deste projeto é atuar como um mensageiro, podendo receber as informações via REST ou Kafka. Posteriormente, ele encaminhará essas solicitações processadas por meio do envio de e-mails.

### Ajustes e melhorias

O projeto ainda está em desenvolvimento, e as próximas atualizações serão focadas nas seguintes tarefas:

- [x] Iniciar o Projeto
- [x] Estabelecer Conectividade com o Banco de Dados
- [x] Mapeamento de Entidades e Repositórios
- [x] Implementação das classes de configuração do Kafka
- [x] Implementar Envio de Email via REST
- [x] Implementar Envio de Email via Kafka
- [x] Desenvolver Documentação
- [ ] Testar aplicação
- [ ] Criar Testes

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

* Você instalou a versão mais recente do `<Java 11>`
* Banco de dados  `<Postgres>`.
* Você tem uma máquina `<Windows / Linux>`.

## ☕ Usando icaro

Para usar icaro, siga estas etapas:

```
-Clone o projeto para o seu ambiente local.
-Abra o projeto na sua IDE preferida.
-Configure as variáveis de ambiente necessárias para o correto funcionamento do projeto.
-Inicie o projeto no ambiente local.
-Consulte a documentação disponível em http://localhost:8080/swagger-ui.html para obter 
 informações detalhadas sobre as APIs e suas funcionalidades.
 ou caso queira rodar a imagem no docker
- docker push rafaelsantos15/icaro
```

Endpoints 
```
    POST: /api/icaro/send
    {
      "userMail": "seuemail@gmail.com",
      "title": "Email de teste",
      "content":"envio de email"
    }
    
    POST: /api/icaro/sync/send
    {
      "userMail": "seuemail@gmail.com",
      "title": "Email de teste",
      "content":"envio de email"
    }
    
```

## 🤝 Colaboradores

Agradecemos às seguintes pessoas que contribuíram para este projeto:

<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/83642989?v=4" width="100px;" alt="Foto do Iuri Silva no GitHub"/><br>
        <sub>
          <b>Rafael Santos</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

## 📝 Licença

Esse projeto está sob licença. Veja o arquivo [LICENÇA](LICENSE.md) para mais detalhes.