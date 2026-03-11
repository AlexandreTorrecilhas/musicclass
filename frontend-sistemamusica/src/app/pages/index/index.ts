import { Component } from "@angular/core";
import { HeaderComponent } from "../../components/header/header.component";
import { RouterOutlet } from "@angular/router";

@Component({
    selector: 'index',
    standalone: true,
    imports: [RouterOutlet, HeaderComponent],
    styleUrl: './index.css',
    templateUrl: './index.html'
})
export class Index{
    
};