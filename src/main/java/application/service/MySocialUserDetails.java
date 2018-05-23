//package application.service;
//
//import application.data.model.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.social.security.SocialUserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class MySocialUserDetails implements SocialUserDetails {
//    private static final long serialVersionUID = -5246117266247684905L;
//
//    private UserService userService;
//
//    private List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
//    private User user;
//
//    public MySocialUserDetails(User user) {
//        this.user = user;
//        String role = userService.findRolesOfUser(user.getId());
//
//        GrantedAuthority grant = new SimpleGrantedAuthority(role);
//        this.list.add(grant);
//    }
//
//    @Override
//    public int getUserId() {
//        return this.user.getId();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return list;
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//}
