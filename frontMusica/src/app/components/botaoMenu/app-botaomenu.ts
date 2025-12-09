import { CommonModule } from "@angular/common";
import { Component, Input } from "@angular/core";
import { LinksInterface } from "../../interfaces/LinksInterface";
import { RouterLink } from "@angular/router";

@Component({
    selector: 'app-botaomenu',
    imports: [CommonModule, RouterLink],
    standalone: true,
    templateUrl: './app-botaomenu.html',
    styleUrl: './app-botaomenu.css'
})
export class AppBotaoMenu{
    @Input() links:LinksInterface[] = []
};