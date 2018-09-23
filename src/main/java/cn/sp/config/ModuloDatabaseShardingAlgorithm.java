package cn.sp.config;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 数据库分片算法
 * Created by 2YSP on 2018/9/23.
 */
public class ModuloDatabaseShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<Long> {
    @Override
    public String doEqualSharding(Collection<String> availableDatabaseNames, ShardingValue<Long> shardingValue) {
        for(String databaseName : availableDatabaseNames){
            if (databaseName.endsWith(shardingValue.getValue() % 2 + "")){

                return databaseName;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<String> doInSharding(Collection<String> availableDatabaseNames, ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(availableDatabaseNames.size());
        for(Long value : shardingValue.getValues()){
            for(String name : availableDatabaseNames){
                if (name.endsWith(value%2 + "")){
                    result.add(name);
                }
            }
        }
        return result;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> availableDatabaseNames, ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(availableDatabaseNames.size());
        Range<Long> range = shardingValue.getValueRange();
        for(Long i = range.lowerEndpoint() ; i < range.upperEndpoint();i++){
            for(String each : availableDatabaseNames){
                if (each.endsWith( i % 2+"")){
                    result.add(each);
                }
            }
        }

        return result;
    }
}
