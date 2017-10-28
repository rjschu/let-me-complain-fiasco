

export class User {
    firstName : string;
    surname : string;
    age : number;
    dateOfBirth : string;
    gender : string;
    telephoneNumber : number;
    emailAddress : string;
    username : string;
    password : string;


    constructor(data?: object) {
        if(data) {
            this.firstName = data['firstName'];
            this.surname = data['surname'];
            this.age = data['age'];
            this.dateOfBirth = data['dateOfBirth'];
            this.gender = data['gender'];
            this.telephoneNumber = data['telephoneNumber'];
            this.emailAddress = data['emailAddress'];
            this.username = data['username'];
            this.password = data['password'];
        }
    }
}