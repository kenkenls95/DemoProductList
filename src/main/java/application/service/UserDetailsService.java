//package application.service;
//
//import application.data.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.social.security.SocialUserDetails;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
//
//    @Autowired
//    private UserService userService;
//
//    public UserDetailsService() {
//
//    }
//
//
//    // (Phương thức này được sử dụng bởi Spring Security API).
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//
//        User user= userService.findUserByUsername(userName);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("No user found with userName: " + userName);
//        }
//
//        // Chú ý: SocialUserDetails mở rộng từ interface UserDetails.
//        SocialUserDetails principal = new MySocialUserDetails(user);
//
//        return principal;
//    }
//}
