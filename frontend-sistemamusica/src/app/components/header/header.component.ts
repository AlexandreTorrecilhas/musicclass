import { Component } from "@angular/core";
import { InterfaceLink } from "../../interfaces/interfacelink";
import { RouterLink } from "@angular/router";
import { CommonModule } from "@angular/common";
import { LINKS_MENU_PRINICPAL } from "./links/linksmenuprincipal";

@Component({
    selector: 'header-component',
    standalone: true,
    imports: [CommonModule, RouterLink],
    templateUrl: './header.component.html',
    styleUrl: './header.component.css'
})
export class HeaderComponent{
    public readonly navLinks:InterfaceLink[] = LINKS_MENU_PRINICPAL;
}