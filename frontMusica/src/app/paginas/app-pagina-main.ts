import { Component } from "@angular/core";
import { AppNavBar } from "../components/barraNavegacao/app-nav-bar";
import { AppBotaoMenu } from "../components/botaoMenu/app-botaomenu";

@Component({
    selector: 'app-pagina-main',
    //This components is the parent one. It will implement and give the inputs that are required by each component
    imports: [AppNavBar, AppBotaoMenu],
    standalone: true,
    templateUrl: './app-pagina-main.html',
    styleUrl: './app-pagina-main.css'
})
export class AppPaginaMain{
    //Both components implement the same interface. When giving the parameters, it isn't required to use the same component's name. Here you are just creating the type
        //input the component requires and giving it a name. The attribuition is done in the '.html' component.
    public navBarLinks = [
        {
            nomeLink: 'Sobre o Sistema',
            caminhoPagina: '/teste'
        }
    ];

    public botaoMenuLinks = [
        {
            nomeLink: 'Lista de Aluno',
            caminhoPagina: '/teste'
        },
        {
            nomeLink: 'Lista de Voluntarios',
            caminhoPagina: '/teste'
        }
    ]
}