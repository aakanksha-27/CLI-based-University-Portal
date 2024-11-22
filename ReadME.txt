Generic Programming:

  Generic class 'Feedback' has been created which contains an ArrayList of generic type T to contain the given feedbacks. This class has been used to create two objects per course - intFeedback and stringFeedback. This reduces redundant programming.

Object Class:

  Object class has been used. Its methods toString() and equals(Object o) have been overridden in multiple classes including Student and TA. 

Exception Handling:

  Robust exception handling has been implemented. Invalid course registration in Student class, Invalid login in Home class, and Course drop failures in Student class have been dealt with.

Assumptions:

  1. One TA can handle only one course which is decided when they sign up, it will permanently remain that way.
  2. There are no pre-existing TAs in the system.
  3. One course has only one TA assigned to it.
  4. All TAs are MTech TAs.
  5. For one course, either TA or admin can assign the grade.
  6. Utopia, no misuse of logins/signups.
  7. Drop date deadlines are 31 Aug and 31 Jan for odd and even semesters respectively.

Demonstration:

Enter user type: 1. Professor 2. Student 3. TA 4. Administrator 5. Exit Program
1
1. Login or 2. Sign Up?
2
Enter email id:
pa
Enter name:
pa
Create password:
pa
Signed up successfully.
Select functionality:
1. Manage Courses
2. View Enrolled Students
3. View Feedback for your Courses
4. Logout
4
Logged out successfully.

Enter user type: 1. Professor 2. Student 3. TA 4. Administrator 5. Exit Program
4
Enter password:
admin123
Login successful.
Choose functionality:
1. Manage Course Catalog
2. Manage Student Records
3. Assign Professors
4. Handle Complaints
5. Logout
1
What do you want to do?
1. View All Courses
2. Add Course
3. Delete Course
4. Go Back
2
Enter course code:
123
Enter title:
abc
Enter professor's name:
pa
Enter credits:
4
Enter number of prerequisites:
1
Enter prerequisites:
A1
Enter timing:
3pm
Enter semester
2
Enter location:
C01
Enter day:
Monday
Enter syllabus:
java
Enter enrollment limit:
2
Enter office hours:
6pm
What do you want to do?
1. View All Courses
2. Add Course
3. Delete Course
4. Go Back
4
Choose functionality:
1. Manage Course Catalog
2. Manage Student Records
3. Assign Professors
4. Handle Complaints
5. Logout
5
Logged out successfully.

Enter user type: 1. Professor 2. Student 3. TA 4. Administrator 5. Exit Program
2
1. Login or 2. Sign Up?
2
Enter email id:
aks
Create password:
123
Signed up successfully.
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
2
Select course title to be registered: 
A6
A3
A7
A1
A2
A4
A5
A1
Course registered successfully.
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
9
Logged out successfully.

Enter user type: 1. Professor 2. Student 3. TA 4. Administrator 5. Exit Program
2
1. Login or 2. Sign Up?
2
Enter email id:
aks
Email already exits.
Enter user type: 1. Professor 2. Student 3. TA 4. Administrator 5. Exit Program
2
1. Login or 2. Sign Up?
2
Enter email id:
akss
Create password:
1233
Signed up successfully.
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
2
Select course title to be registered: 
A6
A3
A7
A1
A2
A4
A5
A1
Course registered successfully.
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
9
Logged out successfully.

Enter user type: 1. Professor 2. Student 3. TA 4. Administrator 5. Exit Program
2
1. Login or 2. Sign Up?
2
Enter email id:
aksss
Create password:
1233
Signed up successfully.
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
2
Select course title to be registered: 
A6
A3
A7
A1
A2
A4
A5
A1
Course registered successfully.
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
5
Enter course to be dropped:
A1
Enter current month:
10
Exception: Drop Deadline Passed.                                              --> DropDealinePassedException
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
5
Enter course to be dropped:
A1
Enter current month:
8
Course dropped successfully.
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
2
Select course title to be registered: 
A6
A3
A7
A1
A2
A4
A5
A1
Course registered successfully.
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
9
Logged out successfully.

Enter user type: 1. Professor 2. Student 3. TA 4. Administrator 5. Exit Program
3
1. Login or 2. Sign Up?
2
Enter email id:
ta1
Create password:
ta1
Signed up successfully.
Enter course code:
101
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. View Student Grades                                                                  --> TA functionality
10. Set Student Grades
11. Logout
10
Which student's grade would you like to assign?
aks
What is the grade?
10
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. View Student Grades
10. Set Student Grades
11. Logout
10
Which student's grade would you like to assign?
akss
What is the grade?
9
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. View Student Grades
10. Set Student Grades
11. Logout
10
Which student's grade would you like to assign?
aksss
What is the grade?
8
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. View Student Grades
10. Set Student Grades
11. Logout
9
aksss: 8
aks: 10
akss: 9
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. View Student Grades
10. Set Student Grades
11. Logout
11
Logged out successfully.

Enter user type: 1. Professor 2. Student 3. TA 4. Administrator 5. Exit Program
2
1. Login or 2. Sign Up?
1
Enter email id:
aks
Enter password:
123
Login successfull.
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
2
Select course title to be registered: 
B6
B7
B1
abc
B2
B5
B3
B4
abc
Course registered successfully.
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
9
Logged out successfully.

Enter user type: 1. Professor 2. Student 3. TA 4. Administrator 5. Exit Program
2
1. Login or 2. Sign Up?
1
Enter email id:
akss
Enter password:
1233
Login successfull.
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
2
Select course title to be registered: 
B6
B7
B1
abc
B2
B5
B3
B4
abc
Course registered successfully.
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
9
Logged out successfully.

Enter user type: 1. Professor 2. Student 3. TA 4. Administrator 5. Exit Program
2
1. Login or 2. Sign Up?
2
Enter email id:
aksss
Email already exits.
Enter user type: 1. Professor 2. Student 3. TA 4. Administrator 5. Exit Program
2
1. Login or 2. Sign Up?
1
Enter email id:
aksss
Enter password:
12 
Exception: Incorrect Credentials.                                                               --> InvalidLoginException
Enter user type: 1. Professor 2. Student 3. TA 4. Administrator 5. Exit Program
2
1. Login or 2. Sign Up?
1
Enter email id:
aksss
Enter password:
1233
Login successful.
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
2
Select course title to be registered: 
B6
B7
B1
abc
B2
B5
B3
B4
abc
Exception: Enrollment limit has been met.                                                      --> CourseFullException
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
9
Logged out successfully.

Enter user type: 1. Professor 2. Student 3. TA 4. Administrator 5. Exit Program
2
1. Login or 2. Sign Up?
1
Enter email id:
aks
Enter password:
123
Login successful.
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
8                                                                                           --> Feedback system
Enter course code:
101
Would you like to give a rating or a review?
rating
Enter integer rating(0-10):
9
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
8
Enter course code:
101
Would you like to give a rating or a review?
review
Enter review:
good
Select functionality:
1. View Available Courses
2. Register for Courses
3. View Schedule
4. Track Academic Progress
5. Drop Courses
6. Submit Complaints
7. View Complaint Status
8. Give Feedback
9. Logout
9
Logged out successfully.

Enter user type: 1. Professor 2. Student 3. TA 4. Administrator 5. Exit Program
1
1. Login or 2. Sign Up?
1
Enter email id:
pa1
Enter password:
pa1
Login successful.
Select functionality:
1. Manage Courses
2. View Enrolled Students
3. View Feedback for your Courses
4. Logout
3
101: 
9
good
Select functionality:
1. Manage Courses
2. View Enrolled Students
3. View Feedback for your Courses
4. Logout
4
Logged out successfully.

Enter user type: 1. Professor 2. Student 3. TA 4. Administrator 5. Exit Program
5

Process finished with exit code 0