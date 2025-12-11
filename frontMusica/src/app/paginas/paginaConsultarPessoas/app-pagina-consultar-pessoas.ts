import { Component } from "@angular/core";
import { AppNavBar } from "../../components/barraNavegacao/app-nav-bar";
import { GerenciarAlunosComponent } from "../../components/formulario/formularioPesquisarPessoas/app-formulario-pesquisar-pessoas";

@Component({
    selector: "app-pagina-consultar-pessoas",
    standalone: true,
    imports: [AppNavBar, GerenciarAlunosComponent],
    templateUrl: "app-pagina-consultar-pessoas.html",
    styleUrl: "app-pagina-consultar-pessoas.css"
})
export class AppPaginaConsultarPessoas{
    public readonly navBarLinks = [
        {nomeLink: 'Página Inicial', caminhoPagina: ''}
    ]
}