
import {Component, OnInit} from "@angular/core";
import {DomSanitizer} from "@angular/platform-browser";
import {FormControl, Validators} from "@angular/forms";
import {GeoService} from "app/newComplaint/geo.service";
import {NewComplaintService} from "./new-complaint.service";

@Component({
  selector: 'new-complaint',
  templateUrl: './new-complaint.html',
  styleUrls: ['./new-complaint.component.css']
})
export class NewComplaintComponent implements OnInit{

  mapLat: number;
  mapLng: number;

  mapPointerLat: number;
  mapPointerLng: number;

  zoom: number;

  typesOfComplaint: object[];
  typesOfLocation: object[];

  reverseGeocodedAddressList : string[];
  complaint: object = {};
  success: boolean = false;
  locationValue: string;

  ngOnInit(): void {
    this.mapLat = 53.4773408;
    this.mapLng = -2.2550053;

    this.mapPointerLat = 53.4773408;
    this.mapPointerLng = -2.2550053;

    this.zoom = 16;

    this.typesOfComplaint = [
      {value: "just angry", view: "Just Angry"},
      {value: "genuine complaint", view: "Genuine Complaint"}
    ]

    this.typesOfLocation = [
      {value: "internet", view: "Internet"},
      {value: "not internet", view: "Not Internet"}
    ]

    this.findLocation()
  }


  constructor(private sanatizer : DomSanitizer, private geoService : GeoService, private complaintService: NewComplaintService) {
  }

  complaintLocationURLFormControl = new FormControl('', [
    Validators.required
  ]);

  getCatVideoURL(){
    return this.sanatizer.bypassSecurityTrustResourceUrl("https://www.youtube.com/embed/smNX8yj1j8o?rel=0&amp;controls=0&amp;showinfo=0;autoplay=1;playlist=XGSy3_Czz8k&loop=1");
  }

  mapClicked($event: any) {
    this.mapPointerLat =  $event.coords.lat;
    this.mapPointerLng =  $event.coords.lng;

    this.findLocation()
  }

  zoomChange(newZoom: number) {
    this.mapLat = this.mapLat + 0.001;
    this.mapLng = this.mapLng - 0.001;
  }

  findLocation(): void {
    this.geoService.getLocation(this.mapPointerLat, this.mapPointerLng)
      .then(
        (response) => {this.reverseGeocodedAddressList = response.results;console.log(this.reverseGeocodedAddressList)}
      );
  }

  submit() {
      this.complaintService.submitComplaint(this.complaint)
        .subscribe(() => {this.success = true;});
  }
}
