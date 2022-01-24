package jp.ac.ccmc._2x.kimatsu2021;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner{

	private final AccountRepository repo;

	@Override
	public void run(String... args) throws Exception{
		repo.save(new Account("志賀 結菜", "2G", "070-8267-5270", "埼玉県ふじみ野市福岡新田53-7"));
		repo.save(new Account("山内 広明", "1D", "070-6866-7266", "埼玉県三郷市前間518-17"));
		repo.save(new Account("野間 絵里", "1S", "070-9451-3984", "東京都江東区有明3-8-14"));
		repo.save(new Account("三浦 千晴", "2E", "070-6098-0257", "千葉県千葉市中央区都町1-749-16"));
		repo.save(new Account("小森 敏宏", "1F", "070-9484-3232", "東京都多摩市山王下1-635-4"));
	}
}
