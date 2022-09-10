package cn.bobdeng.rbac.domain.rbac;


import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdminPassword {
    private Notifier notifier;
    private Store store;
    private PasswordEncoder passwordEncoder;
    private static final String SEEDS = "01234567890";

    public AdminPassword(Notifier notifier, Store store, PasswordEncoder passwordEncoder) {
        this.notifier = notifier;
        this.store = store;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean verify(String password) {
        if (store.get().filter((encodedPassword) -> passwordEncoder.matches(password, encodedPassword))
                .isEmpty()) {
            String newPassword = IntStream.range(0, 20)
                    .map(i -> new Random().nextInt(SEEDS.length()))
                    .mapToObj(i -> SEEDS.substring(i, i + 1))
                    .collect(Collectors.joining());
            notifier.notify(newPassword);
            store.save(passwordEncoder.encode(newPassword));
            return false;
        }
        return true;
    }

    public interface Notifier {
        void notify(String password);
    }

    public interface Store {
        void save(String password);

        Optional<String> get();
    }
}
