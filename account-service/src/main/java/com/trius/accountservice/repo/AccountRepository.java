package com.trius.accountservice.repo;

import com.trius.accountservice.entity.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface AccountRepository extends CassandraRepository<Account, String> {
}
