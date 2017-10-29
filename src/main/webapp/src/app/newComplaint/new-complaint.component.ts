
import {Component} from "@angular/core";
import {DomSanitizer} from "@angular/platform-browser";
import {FormControl, Validators} from "@angular/forms";

@Component({
  selector: 'new-complaint',
  templateUrl: './new-complaint.html',
  styleUrls: ['./new-complaint.component.css']
})
export class NewComplaintComponent {


  constructor(private sanatizer : DomSanitizer) {
  }

  mapLat: number = 53.4773408;
  mapLng: number = -2.2550053;

  mapPointerLat: number = 53.4773408;
  mapPointerLng: number = -2.2550053;


  zoom: number = 16;

  typesOfComplaint = [
    "Just Angry",
    "Genuine Complaint"
  ]

  typesOfLocation = [
    "Internet",
    "Not Internet"
  ]

  complaintLocationURLFormControl = new FormControl('', [
    Validators.required
  ]);

  getCatVideoURL(){
    return this.sanatizer.bypassSecurityTrustResourceUrl("https://www.youtube.com/embed/smNX8yj1j8o?rel=0&amp;controls=0&amp;showinfo=0;autoplay=1;playlist=XGSy3_Czz8k&loop=1");
  }

  mapClicked($event: any) {
    this.mapPointerLat =  $event.coords.lat;
    this.mapPointerLng =  $event.coords.lng;
  }

}
