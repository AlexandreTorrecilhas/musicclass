import { Component } from "@angular/core";
import { HeaderComponent } from "../../components/header/header.component";
import { RouterOutlet } from "@angular/router";
import { FormularioPessoa } from "../../components/formulario/formulario";

@Component({
    selector: 'pessoas',
    standalone: true,
    imports: [RouterOutlet, HeaderComponent, FormularioPessoa],
    styleUrl: './pessoas.css',
    templateUrl: './pessoas.html'
})
export class Pessoas{

}