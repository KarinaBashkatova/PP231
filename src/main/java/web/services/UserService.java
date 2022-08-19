package web.services;

/**
 * @author Karina.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true) //все публичные методы этого класса будут с такой аннотацией, и только чтение. Поэтому там, где нужно изменение, будет своя аннотация,
//имеющая преимущество надо аннотацией класса
public class UserService {
    private final UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> showAllUsers () {
        return usersRepository.findAll();
    }

    public User showUser (int id) {
        Optional<User> foundUser = usersRepository.findById(id);

        return foundUser.orElse(null);
    }
    @Transactional
    public void saveUser(User user) {
        usersRepository.save(user);
    }

    @Transactional
    public void update (int id, User updatedUser) {
        updatedUser.setId(id);
        usersRepository.save(updatedUser);
    }

    @Transactional
    public void delete (int id) {

         usersRepository.deleteById(id);
    }
}
