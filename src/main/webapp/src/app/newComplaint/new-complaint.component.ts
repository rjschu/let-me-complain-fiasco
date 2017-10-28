
import {Component} from "@angular/core";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
    selector: 'new-complaint',
    templateUrl: './new-complaint.html',
    styleUrls: ['./new-complaint.component.css']
})
export class NewComplaintComponent {


    constructor(private sanatizer : DomSanitizer) {
    }

    typesOfComplaint = [
        "Just Angry",
        "Genuine Complaint"
    ]

    typesOfLocation = [
        "Internet",
        "Not Internet"
    ]

    getCatVideoURL(){
        return this.sanatizer.bypassSecurityTrustResourceUrl("https://www.youtube.com/embed/smNX8yj1j8o?rel=0&amp;controls=0&amp;showinfo=0;autoplay=1;playlist=XGSy3_Czz8k&loop=1");
    }

}