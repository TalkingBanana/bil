<template>
    <div id="app">
        <ckeditor :editor="editor" v-model="editorData" :config="editorConfig"></ckeditor>
    </div>
</template>

<script>
    import Editor from 'ckeditor5-custom-build/build/ckeditor';
    export default {
        name: 'app',
        data() {
            return {
                editor: Editor,
                editorData: '<p>Content of the editor.</p>',
                editorConfig: {
                    // The configuration of the editor.
                    simpleUpload: {
                        // 업로드 URL
                        uploadUrl: '/knowledgeUpload',
                        // 헤더 옵션 (선택사항)
                        headers: {
                        'X-CSRF-TOKEN': 'CSRF_TOKEN_VALUE',
                        },
                        method : 'POST'
                }
                }
            };
        }
    }
</script>