import { Component } from "@angular/core";
import { AppNavBar } from "../../components/barraNavegacao/app-nav-bar";
import { AppFormularioAluno } from "../../components/formulario/formularioAluno/app-formulario-aluno";

@Component({
    selector: 'app-pagina-cadastro-aluno',
    imports: [AppNavBar, AppFormularioAluno],
    standalone: true,
    templateUrl: 'app-pagina-cadastro-aluno.html',
    styleUrl: './app-pagina-cadastro-aluno.css'
})
export class AppPaginaCadastroAluno{
    public readonly navBarLinks = [
        {nomeLink: 'Página Inicial', caminhoPagina: ''}
    ]
}