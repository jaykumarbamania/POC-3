export class User{
    name:string;
    surname:string;
    email:string;
    phone:string;
    pincode:string;
    active:string;
    dob:Date;
    joiningDate:Date;
    constructor(
        name:string,
        surname:string,
        email:string,
        phone:string,
        pincode:string,
        active:string,
        dob:Date,
        joiningDate:Date
    ){
        this.name = name;
        this.surname = surname;
        this.email = email
        this.phone = phone;
        this.pincode = pincode;
        this.active = active
        this.dob = dob;
        this.joiningDate = joiningDate;
    }
}