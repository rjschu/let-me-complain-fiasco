
import {Component} from "@angular/core";

@Component({
    selector: 'new-complaint',
    templateUrl: './new-complaint.html',
    styleUrls: ['./new-complaint.component.css']
})
export class NewComplaintComponent {

    typesOfComplaint = [
        "Letting off Steam",
        "Just Angry",
        "Bad person said mean things",
        "Im just bored",
        "Genuine Complaint"
    ]

}