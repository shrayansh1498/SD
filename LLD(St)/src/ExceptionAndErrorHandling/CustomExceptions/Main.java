

class CustomerNotPlusException extends RuntimeException{
    public CustomerNotPlusException(String userId) {
        super("User" + userId + "is not a plus user");
    }
}

class CourseService{
   public void accessCourse(String userId){
    if(hasAccess(userId)){
        throw new CustomerNotPlusException(userId);
    }
   }

   private boolean hasAccess(String userId){
    return true;
   }
}