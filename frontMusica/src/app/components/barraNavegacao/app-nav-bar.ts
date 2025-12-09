import { CommonModule } from "@angular/common";
//The *ngFor is part of the "CommonModule". If is the for loop of angular and because we are going ti use it, this package is required.
import { Component, Input } from "@angular/core";
//  The @input is to make it more modular. With it the component's information that will be displayed can be rendered dynamically based in the attributes that are
//given by the component who called it
import { LinksInterface } from "../../interfaces/LinksInterface";
//Here is an interface that was created to standardize the information it requires.
import { RouterLink } from "@angular/router";
//This importating is required to create links.

@Component({
    selector: 'app-nav-bar',
    standalone: true,
    imports: [CommonModule, RouterLink],
    templateUrl: './app-nav-bar.html',
    styleUrl: './app-nav-bar.css'
})
export class AppNavBar{
    @Input() links:LinksInterface[] = []
}