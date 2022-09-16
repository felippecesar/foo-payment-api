package com.cesarsol.foopaymentapi.domain.service

import mu.KLogger
import mu.KotlinLogging
import org.springframework.stereotype.Service
import redis.clients.jedis.JedisCluster

@Service
class RedisService(val jedisCluster: JedisCluster) {

    val log: KLogger = KotlinLogging.logger { }

    fun get(key: String): String? {
        try {
            with(jedisCluster) {
                return get(key)
            }
        } catch (e: Exception) {
            log.error(e) { "m=set, cannot get value to redis" }
            return null
        }
    }

    fun set(key: String, value: String, expireSeconds: Long=10) {
        try {
            with(jedisCluster) {
                this.set(key, value)
                this.expire(key, expireSeconds)
            }
        } catch (e: Exception) {
            log.error(e) { "m=set, cannot set value to redis" }
        }
    }
}