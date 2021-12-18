package com.smartclass.smartclassmanagement;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController1 {
	public int res;
	public int total_lecture;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TeacherRepository userRepo1;
	
	@Autowired
	private AttendanceRepository attendanceRepo;
	
	
	@RequestMapping("/")
	public String home(Model model)
	{
		model.addAttribute("Home","SmartClassManagement");
		return "home";
		
	}
	
	@RequestMapping("/about")
	public String about(Model model)
	{
		model.addAttribute("About","SmartClassManagement");
		return "about";
		
	}
	
	@RequestMapping("/student_signup")
	public String student_signup(Model model)
	{
		model.addAttribute("Student","Registration");
		model.addAttribute("student", new Student());
		return "student_signup";
		
	}
	
	@RequestMapping("/teacher_signup")
	public String teacher_signup(Model model)
	{
		model.addAttribute("Teacher","Registration");
		model.addAttribute("teacher", new Teacher());
		return "teacher_signup";
		
	}
	
	@RequestMapping(value="/student_register",method=RequestMethod.POST)
	public String registerStudent(@Valid @ModelAttribute("student") Student student,BindingResult result1, @RequestParam(value="agreement",defaultValue="false") boolean agreement, Model model,HttpSession session )
	{
		try{
			if(!agreement)
			{
				System.out.println("You have not agreed the terms and conditions");
				throw new Exception();
			}
			
			//for server Side form Validation
			if(result1.hasErrors())
			{
				System.out.println("error"+result1.toString());
				model.addAttribute("student",student);
				return "student_signup";
			}
				
			System.out.println("Hii");
			System.out.println("Agreement"+agreement);
			System.out.println("Student"+ student);
		    Student student1 = this.userRepo.save(student);
		     model.addAttribute("student",new Student());
		     session.setAttribute("message",new Message("Successfully Registered!!","alert-success"));
		     
		     return "student_signup";
		}
		  
		catch(Exception e)
		{
		
			e.printStackTrace();
			model.addAttribute("student", student);
			session.setAttribute("message",new Message("something went Wrong!!"+e.getMessage(),"alert-error"));
			return "student_signup";
		}
	}
	
	@RequestMapping(value="/teacher_register",method=RequestMethod.POST)
	public String registerTeacher(@Valid @ModelAttribute("teacher") Teacher teacher,BindingResult result1, @RequestParam(value="agreement",defaultValue="false") boolean agreement, Model model,HttpSession session )
	{
		try{
			if(!agreement)
			{
				System.out.println("You have not agreed the terms and conditions");
				throw new Exception();
			}
			
			//for server Side form Validation
			if(result1.hasErrors())
			{
				System.out.println("error"+result1.toString());
				model.addAttribute("student",teacher);
				return "student_signup";
			}
				
			System.out.println("Hii");
			System.out.println("Agreement"+agreement);
			System.out.println("Student"+ teacher);
		   Teacher teacher1 = this.userRepo1.save(teacher);
		    model.addAttribute("student",new Teacher());
		    session.setAttribute("message",new Message("Successfully Registered!!","alert-success"));
		     
		     return "teacher_signup";
		}
		  
		catch(Exception e)
		{
		
			e.printStackTrace();
			model.addAttribute("student", teacher);
			session.setAttribute("message",new Message("something went Wrong!!"+e.getMessage(),"alert-error"));
			return "teacher_signup";
		}
	}
	@RequestMapping("/student_login")
	public String student_login(Model model)
	{
		model.addAttribute("login","Login");
		model.addAttribute("login", new Login());
		return "student_login";
		
	}
	@RequestMapping("/teacher_login")
	public String teacher_login(Model model)
	{
		model.addAttribute("login","Login");
		model.addAttribute("login", new Login());
		return "teacher_login";
		
	}
	
	@RequestMapping(value="/student_login",method=RequestMethod.POST)
	public String loginStudent(@Valid @ModelAttribute("login") Login login,BindingResult result1, @RequestParam(value="agreement",defaultValue="false") boolean agreement, Model model,HttpSession session )
	{
		try{
			if(!agreement)
			{
				System.out.println("You have not agreed the terms and conditions");
				throw new Exception();
			}
			
			//for server Side form Validation
			if(result1.hasErrors())
			{
				System.out.println("error"+result1.toString());
				model.addAttribute("student",login);
				return "student_login";
			}
				
			Student student1 = this.userRepo.getUserByEmail(login.getUsername());
			System.out.println("login"+ login);
			System.out.println("Student "+student1);
			if((student1.getPassword()).equals(login.getPassword()))
			 {
				System.out.println("login"+ login);
				model.addAttribute("student",new Login());
			    
			    return "student_attendance";
			 }
		   
			else
			{
				model.addAttribute("login",login);
				session.setAttribute("message",new Message("invalid Username or password!!","alert-error"));
				return "student_login";
			}
			
		}
		  
		catch(Exception e)
		{
		
			e.printStackTrace();
			model.addAttribute("login",login);
			session.setAttribute("message",new Message("something went Wrong!!"+e.getMessage(),"alert-error"));
			return "student_login";
		}
	}
	
	
	
	@RequestMapping(value="/teacher_login",method=RequestMethod.POST)
	public String loginTeacher(@Valid @ModelAttribute("login") Login login,BindingResult result1, @RequestParam(value="agreement",defaultValue="false") boolean agreement, Model model,HttpSession session )
	{
		try{
			if(!agreement)
			{
				System.out.println("You have not agreed the terms and conditions");
				throw new Exception();
			}
			
			//for server Side form Validation
			if(result1.hasErrors())
			{
				System.out.println("error"+result1.toString());
				model.addAttribute("student",login);
				return "teacher_login";
			}
				
			System.out.println("login"+ login);
			Teacher teacher1 = this.userRepo1.getTeacherByEamil(login.getUsername());
			
			if((teacher1.getPassword()).equals(login.getPassword()))
			 {
				
				model.addAttribute("student",new Login());
			    session.setAttribute("message",new Message("Successfully Login!!","alert-success"));
			    return "active_subject";
			 }
		   
			else
			{
				model.addAttribute("login",login);
				session.setAttribute("message",new Message("invalid Username or password!!","alert-error"));
				return "teacher_login";
			}
			
		}
		  
		catch(Exception e)
		{
		
			e.printStackTrace();
			model.addAttribute("login",login);
			session.setAttribute("message",new Message("something went Wrong!!"+e.getMessage(),"alert-error"));
			return "teacher_login";
		}
	}

	
	
	@RequestMapping("/student_attendance")
	public String student_attendance(Model model)
	{
		model.addAttribute("attendance","attendance");
		model.addAttribute("attendance", new Attendance());
		return "student_attendance";
		
	}
	
	@RequestMapping(value="/student_attendance",method=RequestMethod.POST)
	public String student_attendance_count(@Valid @ModelAttribute("attendance") Attendance attendance,BindingResult result1, @RequestParam(value="agreement",defaultValue="false") boolean agreement, Model model,HttpSession session )
	{
		try{
			if(!agreement)
			{
	
				throw new Exception();
			}
			
			if(result1.hasErrors())
			{
				System.out.println("error"+result1.toString());
				model.addAttribute("attendance",attendance);
				return "student_attendance";
			}
			Attendance attendance1=this.attendanceRepo.getAttendanceBySubjectIdAndScholarNo(attendance.getSubject_id(),attendance.getScholar_no());
			    model.addAttribute("title","Attendane");
			    model.addAttribute("result",attendance1.getCount());
			    model.addAttribute("total_lecture",attendance1.getTotal_lecture());
				res=attendance1.getCount();
				total_lecture=attendance1.getTotal_lecture();
			
			return "result";
		}
		  
		catch(Exception e)
		{
		
			e.printStackTrace();
			model.addAttribute("attendance",attendance);
			session.setAttribute("message",new Message("something went Wrong!!"+e.getMessage(),"alert-error"));
			return "student_attendance";
		}
	}
	@RequestMapping(value="/result",method=RequestMethod.POST)
	public String result(Model model)
	{
		model.addAttribute("title","Attendance");
		model.addAttribute("res",res);
		model.addAttribute("total_lecture", total_lecture);
		return "result";
		
	}
	
	@RequestMapping("/active_subject")
	public String active_subject(Model model)
	{
		model.addAttribute("attendance","attendance");
		model.addAttribute("attendance", new Attendance());
		return "active_subject";
		
	}
	
	@RequestMapping(value="/active_subject",method=RequestMethod.POST)
	public String active_subject(@Valid @ModelAttribute("attendance") Attendance attendance,BindingResult result1, @RequestParam(value="agreement",defaultValue="false") boolean agreement, Model model,HttpSession session )
	{
		try{
			if(!agreement)
			{
	
				throw new Exception();
			}
			
			if(result1.hasErrors())
			{
				System.out.println("error"+result1.toString());
				model.addAttribute("attendance",attendance);
				return "active_subject";
			}
			
			this.attendanceRepo.updateStatus(attendance.getSubject_id(),attendance.getStatus());
			Attendance a1=this.attendanceRepo.getAttendanceBySubjectIdAndScholarNo(attendance.getSubject_id(),1);
			int k=a1.getTotal_lecture();
			k=k+1;
			System.out.println("Total Lecture "+k);
			if((attendance.getStatus()).equals("Active"))
			{
			   this.attendanceRepo.updateLecture(attendance.getSubject_id(),k);
			   System.out.println("Total Lecture "+k);
			}
			
			model.addAttribute("title","Status");
			model.addAttribute("result",res);
				
			
			return "home";
		}
		  
		catch(Exception e)
		{
		
			e.printStackTrace();
			model.addAttribute("attendance",attendance);
			session.setAttribute("message",new Message("something went Wrong!!"+e.getMessage(),"alert-error"));
			return "active_subject";
		}
	}


	
	
	@RequestMapping("/dip")
	public String dip(Model model)
	{
		model.addAttribute("subject","DIP");
		return "dip";
		
	}
	
	
	
	


}
