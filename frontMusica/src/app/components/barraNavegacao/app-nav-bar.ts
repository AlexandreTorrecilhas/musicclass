import { CommonModule } from "@angular/common";
import { Component, Input } from "@angular/core";
import { LinksInterface } from "../../interfaces/LinksInterface";

@Component({
    selector: 'app-nav-bar',
    standalone: true,
    imports: [CommonModule],
    templateUrl: './app-nav-bar.html',
    styleUrl: './app-nav-bar.css'
})
export class AppNavBar{
    @Input() links:LinksInterface[] = []
}