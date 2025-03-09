import {Kafka} from "kafkajs";

const kafka = new Kafka({
    brokers: ['localhost:9094'],
})

const consumer = kafka.consumer({ groupId: 'test-group' })

await consumer.connect()
await consumer.subscribe({ topic: 'response', fromBeginning: true })

await consumer.run({
    eachMessage: async ({ topic, partition, message }) => {
        console.log({
            value: JSON.parse(message.value.toString()),
        })
    },
})