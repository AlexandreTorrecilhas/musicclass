import { Component } from "@angular/core";
import { HeaderComponent } from "../../components/header/header.component";
import { RouterOutlet } from "@angular/router";

@Component({
    selector: 'pessoas',
    standalone: true,
    imports: [RouterOutlet, HeaderComponent],
    styleUrl: './pessoas.css',
    templateUrl: './pessoas.html'
})
export class Pessoas{

}