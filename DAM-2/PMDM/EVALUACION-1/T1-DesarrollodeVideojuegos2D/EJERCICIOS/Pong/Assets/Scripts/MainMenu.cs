using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class MainMenu : MonoBehaviour
{

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKeyDown(KeyCode.Escape))
        {
            exit();
        }

    }

    public void play()
    {
        SceneManager.LoadScene("Pong");
    }

    public void exit()
    {
        Application.Quit();
    }

}
