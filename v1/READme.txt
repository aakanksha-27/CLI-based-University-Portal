-> How to Run my Code?

	As you run the program, you'll be prompted to select your user type. Once you do that, you'll be given the option of logging in or signing up if you're a student or professor. If you choose Administrator, there can only be one. The password for whose login is - "admin123".

	When you successfully login with the correct requested details, the display menu of the chosen user will be shown to you, containing the specific functionalities.

	1. Professor- The professor can:
		Manage your courses (view or edit details)
		View enrolled students
		Logout

	2. Student- The student can:
		View his available courses 
		Register for courses (with checks of prerequisites and credit limits) 
		View his class schedule(day wise) 
		Track his academic progress(specific course grades, sgpa, or cgpa) 
		Drop courses 
		Submit complaints
		View his complaints' status
		Logout

	3. Administrator- The administrator can:
		Manage course catalog (view all courses, add a course, or delete a course)
		Manage student records (view all students or update information)
		Assign professors	
		Handle complaints (view submitted complaints, update complaint status, or filter and update complaints)
		Logout

	In the 'CourseCatalog" class, 56 courses have been hardcoded for testing simplicity. Each has a separate professor assigned to them. Students, however, need to be signed up in order to be utilized.

	Complaint class- A complaint has three attributes namely description, status, and date. The status to begin with is set to "Pending" in the constructor.

	The data you add or delete or modify while in one user session stays remembered until you press "4" to finally terminate the session.

	Just following the instructions being displayed on the screen should be enough to run and test the code.


-> Assumptions made:

	1. The professor can only add existing courses as prerequisites. 
	2. One professor can only take one course.
	3. No course has any prerequisite to begin with.
	4. Underload in a semester is allowed, overload is not.
	5. All grades of one semester are assigned together(in one go).
	6. Sgpa and Cgpa are calculated based on the available completed courses in that semester or otherwise, essentially taking the grade point of the failed courses as 0.
	7. Only one admin exists, logged in with the correct password.
	8. There's no recruitment of professors.
	9. Course code and title cannot be changed.
	10. Courses are semester specific
	11. All courses of the current semester are available to the student, nothing more (failed courses), nothing less(prerequisites are checked later).


-> OOP Concepts:

	1. Classes- 9 classes have been implemented for the organized functionality of the program.

	2. Interface- 'HomePage' interface has been created. This declares starter methods which are later implemented in the 'Home' class.
	
	3. Inheritance- 'User' class has been created which is inherited by three other classes having common functionalities.

	4. Polymorphism- Method overloading and overriding have been used at multiple locations, along with the concept of inheritance.

	5. Encapsulation- Variables and methods have been cautiously categorized as private, public, and protected. Getter and setter functions have been implemented wherever required. 

	6. Abstraction- Abstract class 'User' has been created to provide a structure to its three inheritors. Abstract method 'display menu' is mentioned.

feedback