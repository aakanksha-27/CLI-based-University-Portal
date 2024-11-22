public class CourseCatalog {

    public static void hardcodeCourses(){
        Administrator.getAllCourses().add(new Course("101","A1",new Professor("pa1"),4, "8 am",1,"C101","Monday","sy1",400,"9am - 10am"));
        Administrator.getAllCourses().add(new Course("102","A2",new Professor("pa2"),4, "9 am",1,"C101","Tuesday","sy2",400,"10am - 11am"));
        Administrator.getAllCourses().add(new Course("103","A3",new Professor("pa3"),4, "10 am",1,"C101","Wednesday","sy3",400,"11am - 12pm"));
        Administrator.getAllCourses().add(new Course("104","A4",new Professor("pa4"),4, "11 am",1,"C101","Thursday","sy4",400,"12pm - 1pm"));
        Administrator.getAllCourses().add(new Course("105","A5",new Professor("pa5"),4, "12 pm",1,"C101","Friday","sy5",400,"1pm - 2pm"));
        Administrator.getAllCourses().add(new Course("106","A6",new Professor("pa6"),2, "1 pm",1,"C101","Monday","sy6",400,"2pm - 3pm"));
        Administrator.getAllCourses().add(new Course("107","A7",new Professor("pa7"),2, "2 pm",1,"C101","Tuesday","sy7",400,"3pm - 4pm"));

        Administrator.getAllCourses().add(new Course("201","B1",new Professor("pb1"),4, "8 am",2,"C201","Monday","sy1",400,"9am - 10am"));
        Administrator.getAllCourses().add(new Course("202","B2",new Professor("pb2"),4, "9 am",2,"C201","Tuesday","sy2",400,"10am - 11am"));
        Administrator.getAllCourses().add(new Course("203","B3",new Professor("pb3"),4, "10 am",2,"C201","Wednesday","sy3",400,"11am - 12pm"));
        Administrator.getAllCourses().add(new Course("204","B4",new Professor("pb4"),4, "11 am",2,"C201","Thursday","sy4",400,"12pm - 1pm"));
        Administrator.getAllCourses().add(new Course("205","B5",new Professor("pb5"),4, "12 pm",2,"C201","Friday","sy5",400,"1pm - 2pm"));
        Administrator.getAllCourses().add(new Course("206","B6",new Professor("pb6"),2, "1 pm",2,"C201","Monday","sy6",400,"2pm - 3pm"));
        Administrator.getAllCourses().add(new Course("207","B7",new Professor("pb7"),2, "2 pm",2,"C201","Tuesday","sy7",400,"3pm - 4pm"));

        Administrator.getAllCourses().add(new Course("301","C1",new Professor("pc1"),4, "8 am",3,"C301","Monday","sy1",400,"9am - 10am"));
        Administrator.getAllCourses().add(new Course("302","C2",new Professor("pc2"),4, "9 am",3,"C301","Tuesday","sy2",400,"10am - 11am"));
        Administrator.getAllCourses().add(new Course("303","C3",new Professor("pc3"),4, "10 am",3,"C301","Wednesday","sy3",400,"11am - 12pm"));
        Administrator.getAllCourses().add(new Course("304","C4",new Professor("pc4"),4, "11 am",3,"C301","Thursday","sy4",400,"12pm - 1pm"));
        Administrator.getAllCourses().add(new Course("305","C5",new Professor("pc5"),4, "12 pm",3,"C301","Friday","sy5",400,"1pm - 2pm"));
        Administrator.getAllCourses().add(new Course("306","C6",new Professor("pc6"),2, "1 pm",3,"C301","Monday","sy6",400,"2pm - 3pm"));
        Administrator.getAllCourses().add(new Course("307","C7",new Professor("pc7"),2, "2 pm",3,"C301","Tuesday","sy7",400,"3pm - 4pm"));

        Administrator.getAllCourses().add(new Course("401","D1",new Professor("pd1"),4, "8 am",4,"C401","Monday","sy1",400,"9am - 10am"));
        Administrator.getAllCourses().add(new Course("402","D2",new Professor("pd2"),4, "9 am",4,"C401","Tuesday","sy2",400,"10am - 11am"));
        Administrator.getAllCourses().add(new Course("403","D3",new Professor("pd3"),4, "10 am",4,"C401","Wednesday","sy3",400,"11am - 12pm"));
        Administrator.getAllCourses().add(new Course("404","D4",new Professor("pd4"),4, "11 am",4,"C401","Thursday","sy4",400,"12pm - 1pm"));
        Administrator.getAllCourses().add(new Course("405","D5",new Professor("pd5"),4, "12 pm",4,"C401","Friday","sy5",400,"1pm - 2pm"));
        Administrator.getAllCourses().add(new Course("406","D6",new Professor("pd6"),2, "1 pm",4,"C401","Monday","sy6",400,"2pm - 3pm"));
        Administrator.getAllCourses().add(new Course("407","D7",new Professor("pd7"),2, "2 pm",4,"C401","Tuesday","sy7",400,"3pm - 4pm"));

        Administrator.getAllCourses().add(new Course("501","E1",new Professor("pe1"),4, "8 am",5,"C501","Monday","sy1",400,"9am - 10am"));
        Administrator.getAllCourses().add(new Course("502","E2",new Professor("pe2"),4, "9 am",5,"C501","Tuesday","sy2",400,"10am - 11am"));
        Administrator.getAllCourses().add(new Course("503","E3",new Professor("pe3"),4, "10 am",5,"C501","Wednesday","sy3",400,"11am - 12pm"));
        Administrator.getAllCourses().add(new Course("504","E4",new Professor("pe4"),4, "11 am",5,"C501","Thursday","sy4",400,"12pm - 1pm"));
        Administrator.getAllCourses().add(new Course("505","E5",new Professor("pe5"),4, "12 pm",5,"C501","Friday","sy5",400,"1pm - 2pm"));
        Administrator.getAllCourses().add(new Course("506","E6",new Professor("pe6"),2, "1 pm",5,"C501","Monday","sy6",400,"2pm - 3pm"));
        Administrator.getAllCourses().add(new Course("507","E7",new Professor("pe7"),2, "2 pm",5,"C501","Tuesday","sy7",400,"3pm - 4pm"));

        Administrator.getAllCourses().add(new Course("601","F1",new Professor("pf1"),4, "8 am",6,"C601","Monday","sy1",400,"9am - 10am"));
        Administrator.getAllCourses().add(new Course("602","F2",new Professor("pf2"),4, "9 am",6,"C601","Tuesday","sy2",400,"10am - 11am"));
        Administrator.getAllCourses().add(new Course("603","F3",new Professor("pf3"),4, "10 am",6,"C601","Wednesday","sy3",400,"11am - 12pm"));
        Administrator.getAllCourses().add(new Course("604","F4",new Professor("pf4"),4, "11 am",6,"C601","Thursday","sy4",400,"12pm - 1pm"));
        Administrator.getAllCourses().add(new Course("605","F5",new Professor("pf5"),4, "12 pm",6,"C601","Friday","sy5",400,"1pm - 2pm"));
        Administrator.getAllCourses().add(new Course("606","F6",new Professor("pf6"),2, "1 pm",6,"C601","Monday","sy6",400,"2pm - 3pm"));
        Administrator.getAllCourses().add(new Course("607","F7",new Professor("pf7"),2, "2 pm",6,"C601","Tuesday","sy7",400,"3pm - 4pm"));

        Administrator.getAllCourses().add(new Course("701","G1",new Professor("pg1"),4, "8 am",7,"C701","Monday","sy1",400,"9am - 10am"));
        Administrator.getAllCourses().add(new Course("702","G2",new Professor("pg2"),4, "9 am",7,"C701","Tuesday","sy2",400,"10am - 11am"));
        Administrator.getAllCourses().add(new Course("703","G3",new Professor("pg3"),4, "10 am",7,"C701","Wednesday","sy3",400,"11am - 12pm"));
        Administrator.getAllCourses().add(new Course("704","G4",new Professor("pg4"),4, "11 am",7,"C701","Thursday","sy4",400,"12pm - 1pm"));
        Administrator.getAllCourses().add(new Course("705","G5",new Professor("pg5"),4, "12 pm",7,"C701","Friday","sy5",400,"1pm - 2pm"));
        Administrator.getAllCourses().add(new Course("706","G6",new Professor("pg6"),2, "1 pm",7,"C701","Monday","sy6",400,"2pm - 3pm"));
        Administrator.getAllCourses().add(new Course("707","G7",new Professor("pg7"),2, "2 pm",7,"C701","Tuesday","sy7",400,"3pm - 4pm"));

        Administrator.getAllCourses().add(new Course("801","H1",new Professor("ph1"),4, "8 am",8,"C801","Monday","sy1",400,"9am - 10am"));
        Administrator.getAllCourses().add(new Course("802","H2",new Professor("ph2"),4, "9 am",8,"C801","Tuesday","sy2",400,"10am - 11am"));
        Administrator.getAllCourses().add(new Course("803","H3",new Professor("ph3"),4, "10 am",8,"C801","Wednesday","sy3",400,"11am - 12pm"));
        Administrator.getAllCourses().add(new Course("804","H4",new Professor("ph4"),4, "11 am",8,"C801","Thursday","sy4",400,"12pm - 1pm"));
        Administrator.getAllCourses().add(new Course("805","H5",new Professor("ph5"),4, "12 pm",8,"C801","Friday","sy5",400,"1pm - 2pm"));
        Administrator.getAllCourses().add(new Course("806","H6",new Professor("ph6"),2, "1 pm",8,"C801","Monday","sy6",400,"2pm - 3pm"));
        Administrator.getAllCourses().add(new Course("807","H7",new Professor("ph7"),2, "2 pm",8,"C801","Tuesday","sy7",400,"3pm - 4pm"));
    }
}
