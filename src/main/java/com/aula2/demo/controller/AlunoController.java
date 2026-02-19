package com.aula2.demo.controller;

import com.aula2.demo.model.Aluno;
import com.aula2.demo.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller responsável por tratar as requisições HTTP relacionadas a Alunos.
 *
 * O Controller é a camada que recebe as requisições do navegador,
 * chama a camada de serviço para processar a lógica e retorna a view (página HTML).
 *
 * Fluxo: Navegador → Controller → Service → Repository → Banco de Dados
 *
 * @Controller      - Indica que esta classe é um controller MVC do Spring.
 * @RequestMapping  - Define o prefixo "/alunos" para todas as rotas deste controller.
 * @RequiredArgsConstructor - Lombok: injeta automaticamente as dependências via construtor.
 */
@Controller
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    /**
     * GET /alunos
     * Lista todos os alunos cadastrados.
     *
     * O objeto "Model" é usado para enviar dados do Controller para a View (template HTML).
     * Adicionamos a lista de alunos ao model com a chave "alunos", que será acessada no HTML.
     */
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alunos", alunoService.listarTodos());
        // Retorna o nome do template Thymeleaf: templates/alunos/lista.html
        return "alunos/lista";
    }

    /**
     * GET /alunos/novo
     * Exibe o formulário para cadastrar um novo aluno.
     *
     * Enviamos um objeto Aluno vazio para o formulário poder fazer o binding dos campos.
     */
    @GetMapping("/novo")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "alunos/formulario";
    }

    /**
     * POST /alunos/salvar
     * Recebe os dados do formulário e salva o aluno no banco.
     *
     * O Spring faz o "binding" automaticamente: os campos do formulário HTML
     * são mapeados para os atributos do objeto Aluno pelo nome.
     *
     * @param aluno              - Objeto preenchido automaticamente com os dados do formulário.
     * @param redirectAttributes - Permite enviar mensagens flash (mensagens temporárias após redirect).
     */
    @PostMapping("/salvar")
    public String salvar(Aluno aluno, RedirectAttributes redirectAttributes) {
        alunoService.salvar(aluno);
        redirectAttributes.addFlashAttribute("mensagem", "Aluno salvo com sucesso!");
        // Redireciona para a lista (evita reenvio do formulário ao atualizar a página)
        return "redirect:/alunos";
    }

    /**
     * GET /alunos/editar/{id}
     * Exibe o formulário preenchido com os dados do aluno para edição.
     *
     * @PathVariable - Captura o valor {id} da URL e injeta no parâmetro do método.
     * Exemplo: /alunos/editar/3 → id = 3
     */
    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        Aluno aluno = alunoService.buscarPorId(id);
        model.addAttribute("aluno", aluno);
        return "alunos/formulario";
    }

    /**
     * GET /alunos/excluir/{id}
     * Exclui o aluno com o ID informado e redireciona para a lista.
     */
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        alunoService.excluir(id);
        redirectAttributes.addFlashAttribute("mensagem", "Aluno excluído com sucesso!");
        return "redirect:/alunos";
    }
}
