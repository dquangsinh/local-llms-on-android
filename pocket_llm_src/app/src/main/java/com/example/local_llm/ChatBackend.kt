package com.example.local_llm

interface ChatBackend : AutoCloseable {
    val supportsDirectImageInput: Boolean
        get() = false

    suspend fun initialize()
    suspend fun resetConversation(
        history: List<ChatTurn>,
        thinkingEnabled: Boolean,
        modelInstruction: String
    )

    suspend fun streamReply(
        history: List<ChatTurn>,
        thinkingEnabled: Boolean,
        modelInstruction: String,
        imageFilePaths: List<String> = emptyList(),
        onPartial: (BackendResponse) -> Unit
    ): BackendResponse
    fun cancelGeneration()
}
