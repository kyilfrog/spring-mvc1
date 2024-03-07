package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MemberRepository {
	//실무에서는 동시성 문제를 위해서 ConcurrentHashMap, AtomicLing 사용을 해야
	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;
	
	private static final MemberRepository instance = new MemberRepository();
	
	public static MemberRepository getInstance() {
		return instance;
	}
	
	private MemberRepository() {
	}
		
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}
	
	public Member findById(Long id) {
		return store.get(id);
	}
	
	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}
	
	public void clearStroe() {
		store.clear();
	}
}



























