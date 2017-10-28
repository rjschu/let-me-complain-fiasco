
import {Component} from "@angular/core";

@Component({
    selector: 'new-complaint',
    templateUrl: './new-complaint.html',
    styleUrls: ['./new-complaint.component.css']
})
export class NewComplaintComponent {

    typesOfComplaint = [
        "Letting of Steam",
        "Just Angry",
        "The bad person said mean things to me",
        "Bored, so you decided to make a fake complaint",
        "Genuine Complaint"
    ]

}